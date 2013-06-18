package com.chunkmapper.protoc;
// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: RailRegionContainer.proto

public final class RailRegionContainer {
  private RailRegionContainer() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
  }
  public interface RailRegionOrBuilder
      extends com.google.protobuf.MessageOrBuilder {

    // repeated .RailSection railSections = 1;
    /**
     * <code>repeated .RailSection railSections = 1;</code>
     */
    java.util.List<RailSectionContainer.RailSection> 
        getRailSectionsList();
    /**
     * <code>repeated .RailSection railSections = 1;</code>
     */
    RailSectionContainer.RailSection getRailSections(int index);
    /**
     * <code>repeated .RailSection railSections = 1;</code>
     */
    int getRailSectionsCount();
    /**
     * <code>repeated .RailSection railSections = 1;</code>
     */
    java.util.List<? extends RailSectionContainer.RailSectionOrBuilder> 
        getRailSectionsOrBuilderList();
    /**
     * <code>repeated .RailSection railSections = 1;</code>
     */
    RailSectionContainer.RailSectionOrBuilder getRailSectionsOrBuilder(
        int index);
  }
  /**
   * Protobuf type {@code RailRegion}
   */
  public static final class RailRegion extends
      com.google.protobuf.GeneratedMessage
      implements RailRegionOrBuilder {
    // Use RailRegion.newBuilder() to construct.
    private RailRegion(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
      super(builder);
      this.unknownFields = builder.getUnknownFields();
    }
    private RailRegion(boolean noInit) { this.unknownFields = com.google.protobuf.UnknownFieldSet.getDefaultInstance(); }

    private static final RailRegion defaultInstance;
    public static RailRegion getDefaultInstance() {
      return defaultInstance;
    }

    public RailRegion getDefaultInstanceForType() {
      return defaultInstance;
    }

    private final com.google.protobuf.UnknownFieldSet unknownFields;
    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
      return this.unknownFields;
    }
    private RailRegion(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      initFields();
      int mutable_bitField0_ = 0;
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!parseUnknownField(input, unknownFields,
                                     extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
            case 10: {
              if (!((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
                railSections_ = new java.util.ArrayList<RailSectionContainer.RailSection>();
                mutable_bitField0_ |= 0x00000001;
              }
              railSections_.add(input.readMessage(RailSectionContainer.RailSection.PARSER, extensionRegistry));
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e.getMessage()).setUnfinishedMessage(this);
      } finally {
        if (((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
          railSections_ = java.util.Collections.unmodifiableList(railSections_);
        }
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return RailRegionContainer.internal_static_RailRegion_descriptor;
    }

    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return RailRegionContainer.internal_static_RailRegion_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              RailRegionContainer.RailRegion.class, RailRegionContainer.RailRegion.Builder.class);
    }

    public static com.google.protobuf.Parser<RailRegion> PARSER =
        new com.google.protobuf.AbstractParser<RailRegion>() {
      public RailRegion parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new RailRegion(input, extensionRegistry);
      }
    };

    @java.lang.Override
    public com.google.protobuf.Parser<RailRegion> getParserForType() {
      return PARSER;
    }

    // repeated .RailSection railSections = 1;
    public static final int RAILSECTIONS_FIELD_NUMBER = 1;
    private java.util.List<RailSectionContainer.RailSection> railSections_;
    /**
     * <code>repeated .RailSection railSections = 1;</code>
     */
    public java.util.List<RailSectionContainer.RailSection> getRailSectionsList() {
      return railSections_;
    }
    /**
     * <code>repeated .RailSection railSections = 1;</code>
     */
    public java.util.List<? extends RailSectionContainer.RailSectionOrBuilder> 
        getRailSectionsOrBuilderList() {
      return railSections_;
    }
    /**
     * <code>repeated .RailSection railSections = 1;</code>
     */
    public int getRailSectionsCount() {
      return railSections_.size();
    }
    /**
     * <code>repeated .RailSection railSections = 1;</code>
     */
    public RailSectionContainer.RailSection getRailSections(int index) {
      return railSections_.get(index);
    }
    /**
     * <code>repeated .RailSection railSections = 1;</code>
     */
    public RailSectionContainer.RailSectionOrBuilder getRailSectionsOrBuilder(
        int index) {
      return railSections_.get(index);
    }

    private void initFields() {
      railSections_ = java.util.Collections.emptyList();
    }
    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized != -1) return isInitialized == 1;

      for (int i = 0; i < getRailSectionsCount(); i++) {
        if (!getRailSections(i).isInitialized()) {
          memoizedIsInitialized = 0;
          return false;
        }
      }
      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      getSerializedSize();
      for (int i = 0; i < railSections_.size(); i++) {
        output.writeMessage(1, railSections_.get(i));
      }
      getUnknownFields().writeTo(output);
    }

    private int memoizedSerializedSize = -1;
    public int getSerializedSize() {
      int size = memoizedSerializedSize;
      if (size != -1) return size;

      size = 0;
      for (int i = 0; i < railSections_.size(); i++) {
        size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(1, railSections_.get(i));
      }
      size += getUnknownFields().getSerializedSize();
      memoizedSerializedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    @java.lang.Override
    protected java.lang.Object writeReplace()
        throws java.io.ObjectStreamException {
      return super.writeReplace();
    }

    public static RailRegionContainer.RailRegion parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static RailRegionContainer.RailRegion parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static RailRegionContainer.RailRegion parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static RailRegionContainer.RailRegion parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static RailRegionContainer.RailRegion parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static RailRegionContainer.RailRegion parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }
    public static RailRegionContainer.RailRegion parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input);
    }
    public static RailRegionContainer.RailRegion parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input, extensionRegistry);
    }
    public static RailRegionContainer.RailRegion parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static RailRegionContainer.RailRegion parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }

    public static Builder newBuilder() { return Builder.create(); }
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder(RailRegionContainer.RailRegion prototype) {
      return newBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() { return newBuilder(this); }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessage.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code RailRegion}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessage.Builder<Builder>
       implements RailRegionContainer.RailRegionOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return RailRegionContainer.internal_static_RailRegion_descriptor;
      }

      protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return RailRegionContainer.internal_static_RailRegion_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                RailRegionContainer.RailRegion.class, RailRegionContainer.RailRegion.Builder.class);
      }

      // Construct using RailRegionContainer.RailRegion.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessage.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders) {
          getRailSectionsFieldBuilder();
        }
      }
      private static Builder create() {
        return new Builder();
      }

      public Builder clear() {
        super.clear();
        if (railSectionsBuilder_ == null) {
          railSections_ = java.util.Collections.emptyList();
          bitField0_ = (bitField0_ & ~0x00000001);
        } else {
          railSectionsBuilder_.clear();
        }
        return this;
      }

      public Builder clone() {
        return create().mergeFrom(buildPartial());
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return RailRegionContainer.internal_static_RailRegion_descriptor;
      }

      public RailRegionContainer.RailRegion getDefaultInstanceForType() {
        return RailRegionContainer.RailRegion.getDefaultInstance();
      }

      public RailRegionContainer.RailRegion build() {
        RailRegionContainer.RailRegion result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public RailRegionContainer.RailRegion buildPartial() {
        RailRegionContainer.RailRegion result = new RailRegionContainer.RailRegion(this);
        int from_bitField0_ = bitField0_;
        if (railSectionsBuilder_ == null) {
          if (((bitField0_ & 0x00000001) == 0x00000001)) {
            railSections_ = java.util.Collections.unmodifiableList(railSections_);
            bitField0_ = (bitField0_ & ~0x00000001);
          }
          result.railSections_ = railSections_;
        } else {
          result.railSections_ = railSectionsBuilder_.build();
        }
        onBuilt();
        return result;
      }

      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof RailRegionContainer.RailRegion) {
          return mergeFrom((RailRegionContainer.RailRegion)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(RailRegionContainer.RailRegion other) {
        if (other == RailRegionContainer.RailRegion.getDefaultInstance()) return this;
        if (railSectionsBuilder_ == null) {
          if (!other.railSections_.isEmpty()) {
            if (railSections_.isEmpty()) {
              railSections_ = other.railSections_;
              bitField0_ = (bitField0_ & ~0x00000001);
            } else {
              ensureRailSectionsIsMutable();
              railSections_.addAll(other.railSections_);
            }
            onChanged();
          }
        } else {
          if (!other.railSections_.isEmpty()) {
            if (railSectionsBuilder_.isEmpty()) {
              railSectionsBuilder_.dispose();
              railSectionsBuilder_ = null;
              railSections_ = other.railSections_;
              bitField0_ = (bitField0_ & ~0x00000001);
              railSectionsBuilder_ = 
                com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders ?
                   getRailSectionsFieldBuilder() : null;
            } else {
              railSectionsBuilder_.addAllMessages(other.railSections_);
            }
          }
        }
        this.mergeUnknownFields(other.getUnknownFields());
        return this;
      }

      public final boolean isInitialized() {
        for (int i = 0; i < getRailSectionsCount(); i++) {
          if (!getRailSections(i).isInitialized()) {
            
            return false;
          }
        }
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        RailRegionContainer.RailRegion parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (RailRegionContainer.RailRegion) e.getUnfinishedMessage();
          throw e;
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      // repeated .RailSection railSections = 1;
      private java.util.List<RailSectionContainer.RailSection> railSections_ =
        java.util.Collections.emptyList();
      private void ensureRailSectionsIsMutable() {
        if (!((bitField0_ & 0x00000001) == 0x00000001)) {
          railSections_ = new java.util.ArrayList<RailSectionContainer.RailSection>(railSections_);
          bitField0_ |= 0x00000001;
         }
      }

      private com.google.protobuf.RepeatedFieldBuilder<
          RailSectionContainer.RailSection, RailSectionContainer.RailSection.Builder, RailSectionContainer.RailSectionOrBuilder> railSectionsBuilder_;

      /**
       * <code>repeated .RailSection railSections = 1;</code>
       */
      public java.util.List<RailSectionContainer.RailSection> getRailSectionsList() {
        if (railSectionsBuilder_ == null) {
          return java.util.Collections.unmodifiableList(railSections_);
        } else {
          return railSectionsBuilder_.getMessageList();
        }
      }
      /**
       * <code>repeated .RailSection railSections = 1;</code>
       */
      public int getRailSectionsCount() {
        if (railSectionsBuilder_ == null) {
          return railSections_.size();
        } else {
          return railSectionsBuilder_.getCount();
        }
      }
      /**
       * <code>repeated .RailSection railSections = 1;</code>
       */
      public RailSectionContainer.RailSection getRailSections(int index) {
        if (railSectionsBuilder_ == null) {
          return railSections_.get(index);
        } else {
          return railSectionsBuilder_.getMessage(index);
        }
      }
      /**
       * <code>repeated .RailSection railSections = 1;</code>
       */
      public Builder setRailSections(
          int index, RailSectionContainer.RailSection value) {
        if (railSectionsBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureRailSectionsIsMutable();
          railSections_.set(index, value);
          onChanged();
        } else {
          railSectionsBuilder_.setMessage(index, value);
        }
        return this;
      }
      /**
       * <code>repeated .RailSection railSections = 1;</code>
       */
      public Builder setRailSections(
          int index, RailSectionContainer.RailSection.Builder builderForValue) {
        if (railSectionsBuilder_ == null) {
          ensureRailSectionsIsMutable();
          railSections_.set(index, builderForValue.build());
          onChanged();
        } else {
          railSectionsBuilder_.setMessage(index, builderForValue.build());
        }
        return this;
      }
      /**
       * <code>repeated .RailSection railSections = 1;</code>
       */
      public Builder addRailSections(RailSectionContainer.RailSection value) {
        if (railSectionsBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureRailSectionsIsMutable();
          railSections_.add(value);
          onChanged();
        } else {
          railSectionsBuilder_.addMessage(value);
        }
        return this;
      }
      /**
       * <code>repeated .RailSection railSections = 1;</code>
       */
      public Builder addRailSections(
          int index, RailSectionContainer.RailSection value) {
        if (railSectionsBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureRailSectionsIsMutable();
          railSections_.add(index, value);
          onChanged();
        } else {
          railSectionsBuilder_.addMessage(index, value);
        }
        return this;
      }
      /**
       * <code>repeated .RailSection railSections = 1;</code>
       */
      public Builder addRailSections(
          RailSectionContainer.RailSection.Builder builderForValue) {
        if (railSectionsBuilder_ == null) {
          ensureRailSectionsIsMutable();
          railSections_.add(builderForValue.build());
          onChanged();
        } else {
          railSectionsBuilder_.addMessage(builderForValue.build());
        }
        return this;
      }
      /**
       * <code>repeated .RailSection railSections = 1;</code>
       */
      public Builder addRailSections(
          int index, RailSectionContainer.RailSection.Builder builderForValue) {
        if (railSectionsBuilder_ == null) {
          ensureRailSectionsIsMutable();
          railSections_.add(index, builderForValue.build());
          onChanged();
        } else {
          railSectionsBuilder_.addMessage(index, builderForValue.build());
        }
        return this;
      }
      /**
       * <code>repeated .RailSection railSections = 1;</code>
       */
      public Builder addAllRailSections(
          java.lang.Iterable<? extends RailSectionContainer.RailSection> values) {
        if (railSectionsBuilder_ == null) {
          ensureRailSectionsIsMutable();
          super.addAll(values, railSections_);
          onChanged();
        } else {
          railSectionsBuilder_.addAllMessages(values);
        }
        return this;
      }
      /**
       * <code>repeated .RailSection railSections = 1;</code>
       */
      public Builder clearRailSections() {
        if (railSectionsBuilder_ == null) {
          railSections_ = java.util.Collections.emptyList();
          bitField0_ = (bitField0_ & ~0x00000001);
          onChanged();
        } else {
          railSectionsBuilder_.clear();
        }
        return this;
      }
      /**
       * <code>repeated .RailSection railSections = 1;</code>
       */
      public Builder removeRailSections(int index) {
        if (railSectionsBuilder_ == null) {
          ensureRailSectionsIsMutable();
          railSections_.remove(index);
          onChanged();
        } else {
          railSectionsBuilder_.remove(index);
        }
        return this;
      }
      /**
       * <code>repeated .RailSection railSections = 1;</code>
       */
      public RailSectionContainer.RailSection.Builder getRailSectionsBuilder(
          int index) {
        return getRailSectionsFieldBuilder().getBuilder(index);
      }
      /**
       * <code>repeated .RailSection railSections = 1;</code>
       */
      public RailSectionContainer.RailSectionOrBuilder getRailSectionsOrBuilder(
          int index) {
        if (railSectionsBuilder_ == null) {
          return railSections_.get(index);  } else {
          return railSectionsBuilder_.getMessageOrBuilder(index);
        }
      }
      /**
       * <code>repeated .RailSection railSections = 1;</code>
       */
      public java.util.List<? extends RailSectionContainer.RailSectionOrBuilder> 
           getRailSectionsOrBuilderList() {
        if (railSectionsBuilder_ != null) {
          return railSectionsBuilder_.getMessageOrBuilderList();
        } else {
          return java.util.Collections.unmodifiableList(railSections_);
        }
      }
      /**
       * <code>repeated .RailSection railSections = 1;</code>
       */
      public RailSectionContainer.RailSection.Builder addRailSectionsBuilder() {
        return getRailSectionsFieldBuilder().addBuilder(
            RailSectionContainer.RailSection.getDefaultInstance());
      }
      /**
       * <code>repeated .RailSection railSections = 1;</code>
       */
      public RailSectionContainer.RailSection.Builder addRailSectionsBuilder(
          int index) {
        return getRailSectionsFieldBuilder().addBuilder(
            index, RailSectionContainer.RailSection.getDefaultInstance());
      }
      /**
       * <code>repeated .RailSection railSections = 1;</code>
       */
      public java.util.List<RailSectionContainer.RailSection.Builder> 
           getRailSectionsBuilderList() {
        return getRailSectionsFieldBuilder().getBuilderList();
      }
      private com.google.protobuf.RepeatedFieldBuilder<
          RailSectionContainer.RailSection, RailSectionContainer.RailSection.Builder, RailSectionContainer.RailSectionOrBuilder> 
          getRailSectionsFieldBuilder() {
        if (railSectionsBuilder_ == null) {
          railSectionsBuilder_ = new com.google.protobuf.RepeatedFieldBuilder<
              RailSectionContainer.RailSection, RailSectionContainer.RailSection.Builder, RailSectionContainer.RailSectionOrBuilder>(
                  railSections_,
                  ((bitField0_ & 0x00000001) == 0x00000001),
                  getParentForChildren(),
                  isClean());
          railSections_ = null;
        }
        return railSectionsBuilder_;
      }

      // @@protoc_insertion_point(builder_scope:RailRegion)
    }

    static {
      defaultInstance = new RailRegion(true);
      defaultInstance.initFields();
    }

    // @@protoc_insertion_point(class_scope:RailRegion)
  }

  private static com.google.protobuf.Descriptors.Descriptor
    internal_static_RailRegion_descriptor;
  private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_RailRegion_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\031RailRegionContainer.proto\032\032RailSection" +
      "Container.proto\"0\n\nRailRegion\022\"\n\014railSec" +
      "tions\030\001 \003(\0132\014.RailSection"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
      new com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner() {
        public com.google.protobuf.ExtensionRegistry assignDescriptors(
            com.google.protobuf.Descriptors.FileDescriptor root) {
          descriptor = root;
          internal_static_RailRegion_descriptor =
            getDescriptor().getMessageTypes().get(0);
          internal_static_RailRegion_fieldAccessorTable = new
            com.google.protobuf.GeneratedMessage.FieldAccessorTable(
              internal_static_RailRegion_descriptor,
              new java.lang.String[] { "RailSections", });
          return null;
        }
      };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          RailSectionContainer.getDescriptor(),
        }, assigner);
  }

  // @@protoc_insertion_point(outer_class_scope)
}
